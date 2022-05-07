package com.gsd.fifa4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class GameRecordApplication {

    public static void main(String[] args) {
        SpringApplication application  = new SpringApplication(GameRecordApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
    }


//    @Component
//    @RequiredArgsConstructor
//    public static class Runner implements ApplicationRunner {
//
//        private final ClubPriceRankRepository clubPriceRankRepository;
//
//        @Override
//        public void run(ApplicationArguments args) throws Exception {
//
//            for(int i=1; i<20; i++) {
//                ClubPriceRank clubPriceRank =
//                        new ClubPriceRank("abc" + i , "abc",  String.valueOf(i), LocalDateTime.now());
//
//                clubPriceRankRepository.save(clubPriceRank);
//            }
//        }
//    }
}
