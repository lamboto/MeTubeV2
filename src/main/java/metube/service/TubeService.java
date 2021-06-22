package metube.service;

import metube.domain.entities.Tube;
import metube.domain.model.TubeServiceModel;

import java.util.List;

public interface TubeService {

    void create(String title, String author, String description, String youtubeId, int userId);

    List<TubeServiceModel> getAllByGivenUsername(String username);

    TubeServiceModel findById(Integer id);

    TubeServiceModel getTubeDetail(int tubeId);

    List<TubeServiceModel> getAllTubes();
}
