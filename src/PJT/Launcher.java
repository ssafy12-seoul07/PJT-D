package PJT;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
//import java.util.gson.Gson;
//import java.util.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Launcher {
    public static void main(String[] args) {
        IVideoManager videoManager = new VideoManager();
        IReviewManager reviewManager = new ReviewManager();
        Scanner scanner = new Scanner(System.in);

        List<Video> videosFromFile = JsonUtil.loadVideos("data/video.json");
        if (videosFromFile != null) {
            for (Video video : videosFromFile) {
                videoManager.addVideo(video);
            }
        }

        boolean exit = false;
        while (!exit) {
        	System.out.print("\n-------------------------");
        	System.out.print("\n---WELCOME TO SSAFIDEO---");
        	System.out.print("\n-------------------------");
            System.out.println("\n-------- 메인 메뉴 --------");
            System.out.println("1. 영상 목록 보기");
            System.out.println("2. 종료");

            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                	showVideoList(videoManager, reviewManager, scanner);
//                    List<String> videos = videoManager.listVideos();
//                    for (String video : videos) {
//                        System.out.println(video);
//                    }
                    break;
                case 2:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }
//    private static void showVideoList(IVideoManager videoManager) {
//        List<String> videos = videoManager.listVideos();
//        for (String video : videos) {
//            System.out.println(video);
//        }
//        promptToContinue();
//    }
    private static void showVideoList(IVideoManager videoManager, IReviewManager reviewManager, Scanner scanner) {
        boolean goBack = false;
        while (!goBack) {
            List<String> videos = videoManager.listVideos();
            for (String video : videos) {
                System.out.println(video);
            }
            System.out.println("\n영상 번호를 입력하세요 (돌아가려면 0을 누르세요)");

            System.out.print("선택: ");
            int videoNo = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            if (videoNo == 0) {
                goBack = true;
            } else {
                Video selectedVideo = null;
                for (Video video : videoManager.getVideos()) {
                    if (video.getNo() == videoNo) {
                        selectedVideo = video;
                        break;
                    }
                }

                if (selectedVideo != null) {
                    showVideoDetail(selectedVideo, reviewManager, scanner);
                } else {
                    System.out.println("잘못된 영상 번호입니다. 다시 시도하세요.");
                }
            }
        }
    }

    private static void showVideoDetail(Video video, IReviewManager reviewManager, Scanner scanner) {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("\n------------");
            System.out.println("영상 상세");
            System.out.println("-----------");
            System.out.println("영상 제목: " + video.getTitle());
            System.out.println("영상 설명: " + video.getPart());
            System.out.println("영상 링크(URL): " + video.getUrl());
            System.out.println("---------------");
            System.out.println("최근 리뷰");
            List<String> reviews = reviewManager.listReviews(video.getNo());
            for (int i = 0; i < reviews.size(); i++) {
                System.out.println((i + 1) + ". " + reviews.get(i));
            }
            System.out.println("----------------");
            System.out.println("1. 리뷰 작성");
            System.out.println("2. 돌아가기");

            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    writeReview(video, reviewManager, scanner);
                    break;
                case 2:
                    goBack = true;
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    private static void writeReview(Video video, IReviewManager reviewManager, Scanner scanner) {
        System.out.print("User: ");
        String user = scanner.nextLine();
        System.out.print("리뷰 작성: ");
        String content = scanner.nextLine();
        System.out.print("평점(1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        Review review = new Review(user, content, rating);
        reviewManager.addReview(video.getNo(), review);
        System.out.println("리뷰가 추가되었습니다.");

        System.out.println("1. 돌아가기");
        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기
            if (choice == 1) {
                break;
            } else {
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }
}
//    private static void promptToContinue() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("돌아가려면 엔터 키를 누르세요...");
//        scanner.nextLine();
