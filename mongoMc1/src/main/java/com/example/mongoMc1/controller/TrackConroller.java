package com.example.mongoMc1.controller;

import com.example.mongoMc1.domain.Track;
import com.example.mongoMc1.exception.CustomerAlreadyExistException;
import com.example.mongoMc1.exception.CustomerNotFoundException;
import com.example.mongoMc1.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TrackConroller {
    ITrackService trackService;
    @Autowired
    public TrackConroller(ITrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/track")
    public ResponseEntity<?>addTrack(@RequestBody Track track)throws CustomerAlreadyExistException {
        return new ResponseEntity<>(trackService.addTrack(track), HttpStatus.CREATED);
    }
    @GetMapping("/track")
    public ResponseEntity<?>getAllTrack(){
        return new ResponseEntity<>(trackService.grtAllTrack(),HttpStatus.OK);
    }
    @DeleteMapping("/track/{id}")
    public ResponseEntity<?>deleteTrack(@PathVariable int id)throws CustomerNotFoundException {
        return new ResponseEntity<>(trackService.deleteTrack(id),HttpStatus.OK);
    }
    @GetMapping("/trackArtist/{name}")
    public ResponseEntity<?>getAllTrackByArtistName(@PathVariable String name){
        return new ResponseEntity<>(trackService.getTrackByArtistName(name),HttpStatus.OK);
    }
    @GetMapping("/trackRating/{rateid}")
    public ResponseEntity<?>getAllTrackByRatingGreaterthan4(@PathVariable int rateid){
        return new ResponseEntity<>(trackService.getTrackByRatingGreaterThan4(rateid),HttpStatus.OK);
    }
}
