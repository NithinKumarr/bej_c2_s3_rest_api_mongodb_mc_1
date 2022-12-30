package com.example.mongoMc1.service;

import com.example.mongoMc1.domain.Track;
import com.example.mongoMc1.exception.CustomerAlreadyExistException;
import com.example.mongoMc1.exception.CustomerNotFoundException;

import java.util.List;

public interface ITrackService {
    public Track addTrack(Track track)throws CustomerAlreadyExistException;
    public List<Track> grtAllTrack();
    public String deleteTrack(int trackId)throws CustomerNotFoundException;
    public List<Track>getTrackByArtistName(String artistName);
    public List<Track>getTrackByRatingGreaterThan4(int trackrating);
}
