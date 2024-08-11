package com.example.JustGetStartedBackEnd.API.Team.Controller;

import com.example.JustGetStartedBackEnd.API.Team.DTO.TeamListDTO;
import com.example.JustGetStartedBackEnd.API.Team.Service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {
        private final TeamService teamService;
        private final int SIZE = 10;

        //페이징 처리
        @GetMapping("/all")
        public ResponseEntity<TeamListDTO> getAllTeams(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(required = false) String keyword,
                                                       @RequestParam(required = false) String tier
                                                       ) {
            TeamListDTO teamListDTO = teamService.findAll(page, SIZE, keyword, tier);

            return ResponseEntity.status(HttpStatus.OK).body(teamListDTO);
        }

        @GetMapping("/info")
        public ResponseEntity<?> getTeamInfo(@RequestParam("teamName") String teamName) {
            return ResponseEntity.status(HttpStatus.OK).body(teamService.findByTeamName(teamName));
        }
}