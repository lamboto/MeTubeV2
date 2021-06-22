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
        tube.setYoutubeId(youtubeId.split("=")[1]);
        tube.setUserId(userId);

        this.tubeRepository.save(this.mapper.map(tube, Tube.class));
    }

    @Override
    public List<TubeServiceModel> getAllByGivenUsername(String username) {
        return this.tubeRepository.findAllByGivenUsername(username);
    }

    @Override
    public TubeServiceModel findById(Integer id) {
        Tube tube = this.tubeRepository.findById(id);

        if (tube == null) {
            throw new IllegalArgumentException();
        }

        return this.mapper.map(tube, TubeServiceModel.class);
    }

    @Override
    public TubeServiceModel getTubeDetail(int tubeId) {
        TubeServiceModel tube = findById(tubeId);

        tube.setViews(tube.getViews() + 1);

        this.tubeRepository.update(mapper.map(tube, Tube.class));
        return findById(tubeId);
    }

}
