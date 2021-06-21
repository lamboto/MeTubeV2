package metube.service.impl;

import metube.config.Mapper;
import metube.domain.entities.Tube;
import metube.domain.model.TubeCreateServiceModel;
import metube.domain.model.TubeServiceModel;
import metube.repository.TubeRepositoryImpl;
import metube.service.TubeService;

import java.util.List;

public class TubeServiceImpl implements TubeService {

    private final TubeRepositoryImpl tubeRepository = new TubeRepositoryImpl();
    private final Mapper mapper = new Mapper();

    @Override
    public void create(String title, String author, String description, String youtubeId, int userId) {
        TubeCreateServiceModel tube = new TubeCreateServiceModel();

        tube.setTitle(title);
        tube.setAuthor(author);
        tube.setDescription(description);
        tube.setYoutubeId(youtubeId);
        tube.setUserId(userId);

        this.tubeRepository.save(this.mapper.map(tube, Tube.class));
    }

    @Override
    public List<TubeServiceModel> getAllByGivenUsername(String username) {
        return this.tubeRepository.findAllByGivenUsername(username);
    }

    @Override
    public Tube findById(Integer id) {
        return this.tubeRepository.findById(id);
    }

}
