package com.cu.back.train.utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.cu.back.train.model.core.HttpResponse;

public class JsonUtils {
	
	public class TimestampLongFormatTypeAdapter extends TypeAdapter<Timestamp> {

		@Override
		public void write(JsonWriter out, Timestamp value) throws IOException {
			
			System.out.println("--------------value-------------");
			System.out.println(value);
			if (value != null) {
				System.out.println("------------if--value-------------");
				System.out.println(value);
				out.value(value.getTime());
			}
			else {
				System.out.println("------------else--value-------------");
				System.out.println(value);
				out.nullValue();
			}
				
		}

		@Override
		public Timestamp read(JsonReader in) throws IOException {
			return new Timestamp(in.nextLong());
		}

	}

	public static Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonUtils().new TimestampLongFormatTypeAdapter()).create();
	
	public static ObjectMapper mapper = new ObjectMapper();

	public static <T> ArrayList<T> parseToArray(String json, Class<T> cls) {
		Type type = TypeToken.getParameterized(ArrayList.class, cls).getType();
		if (CoreUtils.isEmpty(json)) {
			return gson.fromJson("[]", type);
		}
		return gson.fromJson(json, type);
	}

	public static <T> T parseToObject(String json, Class<T> cls) {
		if (CoreUtils.isEmpty(json)) {
			return null;
		}
		Type type = TypeToken.getParameterized(cls).getType();
		return gson.fromJson(json, type);
	}

	public static <T> String toJson(T obj) {
		return gson.toJson(obj);
	}

	public static <T> T jacksonParseToObject(String json, Class<T> cls)
			throws JsonParseException, JsonMappingException, IOException {
		if (CoreUtils.isEmpty(json)) {
			return null;
		}
		return mapper.readValue(json, cls);
	}

	public static List<Map<String, Object>> parseToListMap(String json) {
		if (CoreUtils.isEmpty(json)) {
			return null;
		}
		Type resultType = new TypeToken<List<Map<String, Object>>>() {
		}.getType();
		return gson.fromJson(json, resultType);
	}

	public static Map<String, Object> parseToMap(String json) {
		if (CoreUtils.isEmpty(json)) {
			return null;
		}
		Type resultType = new TypeToken<Map<String, Object>>() {
		}.getType();
		return gson.fromJson(json, resultType);
	}

	public static Exception getException(HttpResponse response) {
		return new Exception("Http Response Error Code : " + response.getResponseCode() + ", Message : "
				+ response.getResponseBody());
	}

}
