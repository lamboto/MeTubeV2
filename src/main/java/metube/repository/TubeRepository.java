package metube.repository;

import metube.domain.entities.Tube;
import metube.domain.model.TubeServiceModel;

import java.util.List;

public interface TubeRepository extends GenericRepository<Tube, Integer> {

    List<TubeServiceModel> findAllByGivenUsername(String username);

    void update(Tube tube);
}
