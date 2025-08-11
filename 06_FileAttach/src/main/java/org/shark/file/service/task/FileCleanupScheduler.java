package org.shark.file.service.task;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.shark.file.repository.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 매일 1회(새벽 3시),
 * "어제" 날짜의 폴더(upload/yyyy/MM/dd)에 저장된 파일들 중에서
 * 데이터베이스 테이블에 정보가 없는 첨부파일들을 찾아서 자동으로 삭제하는 스케쥴러.
 */

@Service   //@Component 등록도 가능합니다.
public class FileCleanupScheduler {

  @Autowired
  private NoticeDAO noticeDAO;
  
             //초 분 시 일 월 요일
  @Scheduled(cron = "0 0 3 * * *") //매일 새벽 3시를 의미하는 "크론식"을 작성합니다.  <<  크론식 각자 보충 공부
                                   //스케쥴러 동작 허용을 위한 @EnableScheduling 어노테이션(Java Config 파일에 작성) 또는 <task: annotation-driven /> 태그가 필요합니다.
  public void cleanupUnusedFiles() {                    
    
    //1. 어제 날짜의 폴더 경로 계산
    LocalDate yesterday = LocalDate.now().minusDays(1);
    String dirPath = "/upload" + yesterday.format(DateTimeFormatter.ofPattern("/yyyy/MM/dd"));
    
    //2. 해당 폴더의 파일 목록 조회
    File dir = new File(dirPath);
    if(!dir.exists() || !dir.isDirectory()) {
      return;
    }
    File[] files = dir.listFiles();
    List<String> storedFilenames = Arrays.stream(files)
                                         .map(file -> file.getName())
                                         .collect(Collectors.toList());
    
    //3. DB에서 해당 경로를 가진 첨부파일 목록 조회
    
    
    //4. 비교 및 삭제(삭제된 파일의 로그 남기기)
    
    
  }
  
}




