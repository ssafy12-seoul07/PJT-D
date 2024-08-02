package PJT;

import java.util.List;

	public interface IVideoManager {
	    void addVideo(Video video);
	    List<Video> searchVideos(String part);
	    List<String> listVideos();
	    List<Video> getVideos();
	}

