package cs5200_spring2020.demo.repository;

import cs5200_spring2020.demo.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Integer> {
}
