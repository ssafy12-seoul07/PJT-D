package PJT;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {
	    public static List<Video> loadVideos(String filePath) {
	        Gson gson = new Gson();
	        try (FileReader reader = new FileReader(filePath)) {
	            Type videoListType = new TypeToken<List<Video>>(){}.getType();
	            return gson.fromJson(reader, videoListType);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	}
