package com.example.mongoMc1.service;

import com.example.mongoMc1.domain.Track;
import com.example.mongoMc1.exception.CustomerAlreadyExistException;
import com.example.mongoMc1.exception.CustomerNotFoundException;
import com.example.mongoMc1.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements ITrackService{
    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track addTrack(Track track) throws CustomerAlreadyExistException {
        if(trackRepository.findById(track.getTrackId()).isEmpty()){
            return trackRepository.save(track);
        }
        throw new CustomerAlreadyExistException();
    }

    @Override
    public List<Track> grtAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public String deleteTrack(int trackId) throws CustomerNotFoundException {
        if(trackRepository.findById(trackId).isEmpty()){
            throw new CustomerNotFoundException();
        }
        trackRepository.deleteById(trackId);
        return "Track deleted succfully";
    }

    @Override
    public List<Track> getTrackByArtistName(String artistName) {
        return trackRepository.findAllTrackByArtistName(artistName);
    }
    @Override
    public List<Track> getTrackByRatingGreaterThan4(int trackRating) {
        return trackRepository.findAllTrackByRatingGreaterThan4(trackRating);
    }
}
