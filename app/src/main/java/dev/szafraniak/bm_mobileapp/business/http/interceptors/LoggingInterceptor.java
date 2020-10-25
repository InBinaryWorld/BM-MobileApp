package dev.szafraniak.bm_mobileapp.business.http.interceptors;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import timber.log.Timber;

public class LoggingInterceptor implements Interceptor {

    @Override
    public @NotNull Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        logRequest(request);

        long sendTime = System.nanoTime();
        Response response = chain.proceed(request);
        double responseTime = (System.nanoTime() - sendTime) / 1e9d;


        ResponseBody responseBody;
        String responseContent = "{{ binary data }}";
        MediaType contentType = Objects.requireNonNull(response.body()).contentType();
        if (hasRepresentation(contentType)) {
            responseContent = Objects.requireNonNull(response.body()).string();
            responseBody = ResponseBody.create(responseContent, contentType);
        } else {
            responseBody = ResponseBody.create(Objects.requireNonNull(response.body()).bytes(), contentType);
        }

        logResponse(response, responseContent, responseTime);
        return response.newBuilder().body(responseBody).build();
    }


    private void logRequest(Request request) {
        String parameters = "";
        String method = request.method().toLowerCase();
        if (method.equals("post") || method.equals("put")) {
            parameters = "Body: {\n" + parseBody(request) + "\n}";
        }
        Timber.d("[SENT][%s][%s] %s", request.method(), request.url(), parameters);
    }

    private void logResponse(Response response, String responseContent, double responseTime) {
        Timber.d("[RECEIVED][%s][%d][%.2fs]\nBody: %s",
            response.request().url(), response.code(), responseTime, responseContent);
    }

    private boolean hasRepresentation(MediaType contentType) {
        return contentType != null &&
            ("json".equalsIgnoreCase(contentType.subtype()) || "text".equalsIgnoreCase(contentType.type()));
    }

    static String parseBody(Request request) {
        try {
            Request copy = request.newBuilder().build();
            Buffer buffer = new Buffer();
            Objects.requireNonNull(copy.body()).writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            Timber.e(e, "Cannot parse body to string");
            return "Parsing Error";
        }
    }
}

