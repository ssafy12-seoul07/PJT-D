package PJT;

import java.util.ArrayList;
import java.util.List;

public class VideoManager implements IVideoManager  {
    private List<Video> videos;

    public VideoManager() {
        this.videos = new ArrayList<>();
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public List<Video> searchVideos(String part) {
        List<Video> result = new ArrayList<>();
        for (Video video : videos) {
            if (video.getPart().contains(part)) {
                result.add(video);
            }
        }
        return result;
    }

    public List<String> listVideos() {
        List<String> videoInfos = new ArrayList<>();
        for (Video video : videos) {
            videoInfos.add(video.getInfo());
        }
        return videoInfos;
    }

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
}
