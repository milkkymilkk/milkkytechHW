package com.cu.back.train.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.cu.back.train.model.core.HttpResponse;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
public class HttpRequestUtils {

	public static HttpResponse httpGet(String authorization, String url, Map<String, String> param, OkHttpClient client)
			throws Exception {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

		if (CoreUtils.isNotNull(param)) {
			for (Map.Entry<String, String> entry : param.entrySet()) {
				urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
			}
		}

		String buildUrl = urlBuilder.build().toString();

		log.debug("<< buildUrl << {} ", buildUrl);

		Request request = new Request.Builder().url(buildUrl).get().header("Authorization", authorization)
				.header("Accept", "application/json").header("Content-type", "application/json; charset=utf-8").build();
		try (Response response = client.newCall(request).execute()) {
			int responseCode = response.code();
			String responseBody = response.body().string();
			HttpResponse httpResponse = new HttpResponse();
			httpResponse.setResponseCode(responseCode);
			httpResponse.setResponseBody(responseBody);
			log.debug("<< {}", httpResponse);
			return httpResponse;
		}
	}

	public static String httpDelete(String authorization, String url, OkHttpClient client) throws Exception {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		String buildUrl = urlBuilder.build().toString();

		Request request = new Request.Builder().url(buildUrl).delete().header("Authorization", authorization)
				.header("Accept", "application/json").header("Content-type", "application/json").build();
		try (Response response = client.newCall(request).execute()) {
			int responseCode = response.code();
			String responseBody = response.body().string();
			log.debug("<< {} << {} ", responseCode, responseBody);
			return responseBody;
		}
	}

	public static String httpPost(String authorization, String url, String jsonParam, OkHttpClient client)
			throws Exception {
				log.debug("<< {} << {} ", url, jsonParam);
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		String buildUrl = urlBuilder.build().toString();
		RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParam);

		Request request = new Request.Builder().url(buildUrl).post(body).header("Authorization", authorization)
				.header("Accept", "application/json").header("Content-type", "application/json").build();
		try (Response response = client.newCall(request).execute()) {
			int responseCode = response.code();
			String responseBody = response.body().string();
			log.debug("<< {} << {} ", responseCode, responseBody);
			return responseBody;
		}
	}
	
	public static String httpPost(String url, String jsonParam, OkHttpClient client)
			throws Exception {
				log.debug("<< {} << {} ", url, jsonParam);
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		String buildUrl = urlBuilder.build().toString();
		RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParam);

		Request request = new Request.Builder().url(buildUrl).post(body).header("Accept", "application/json").header("Content-type", "application/json").build();
		try (Response response = client.newCall(request).execute()) {
			int responseCode = response.code();
			String responseBody = response.body().string();
			log.debug("<< {} << {} ", responseCode, responseBody);
			return responseBody;
		}
	}

	public static String httpPostMultipartByte(String authorization, String fileName, byte[] fileByte,
			MediaType mediaType, String url, Map<String, String> param, OkHttpClient client) throws Exception {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

		if (CoreUtils.isNotNull(param)) {
			for (Map.Entry<String, String> entry : param.entrySet()) {
				urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
			}
		}

		String buildUrl = urlBuilder.build().toString();

		RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addFormDataPart("file", fileName, RequestBody.create(mediaType, fileByte)).build();

		Request request = new Request.Builder().url(buildUrl).post(body).header("Authorization", authorization)
				.header("Accept", "application/json").header("Content-type", "application/json").build();

		try (Response response = client.newCall(request).execute()) {
			int responseCode = response.code();
			String responseBody = response.body().string();
			log.debug("<< {} << {} ", responseCode, responseBody);
			return responseBody;
		}

	}

	public static String httpPostFormBody(String authorization, String url, Map<String, String> param,
			OkHttpClient client) throws IOException, SQLException {
		Builder formBuilder = new FormBody.Builder();
		if (CoreUtils.isNotNull(param)) {
			for (Map.Entry<String, String> entry : param.entrySet()) {
				formBuilder.add(entry.getKey(), entry.getValue());
			}
		}
		RequestBody formBody = formBuilder.build();
		Request request = new Request.Builder().url(url).post(formBody).header("Authorization", authorization)
				.header("Accept", "application/json").header("Content-type", "application/json").build();
		try (Response response = client.newCall(request).execute()) {
			int responseCode = response.code();
			String responseBody = response.body().string();
			log.debug("<< {} << {} ", responseCode, responseBody);
			return responseBody;
		}
	}

	public static String getCredential(String username, String password){
		return Credentials.basic(username, password);
	}

	public static Exception getException(HttpResponse response){
		return new Exception("Http Response Error Code : "+ response.getResponseCode() +", Message : "+ response.getResponseBody());
	}

	static String codeToTxt(int code) {
        String out = "";
        switch (code) {
        case 200:
            out = "200 OK";
            break;
        case 400:
            out = "400 Bad Request";
            break;
        case 401:
            out = "401 Unauthorized";
            break;
        case 403:
            out = "403 Forbidden";
            break;
        case 405:
            out = "405 Method Not Allowed";
            break;
        case 429:
            out = "429 Too Many Requests";
            break;
        case 500:
            out = "500 Server Error";
            break;
        default:
            out = code + " Unimplement Text in Java";
            break;
        }
        return out;
    }

}
