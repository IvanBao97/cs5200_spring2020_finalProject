package cs5200_spring2020.demo.repository;

import cs5200_spring2020.demo.domain.Message;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Integer> {
    @Query("select message from Message message")
    public List<Message> findAllMessages();

    @Query("select message from Message message where message.id=:mid")
    public Message findMessageById(@Param("mid") Integer messageId);

    @Transactional
    @Modifying
    @Query("delete from Message message")
    public void deleteAllMessages();

    @Transactional
    @Modifying
    @Query("delete from Message message where message.id=:mid")
    public void deleteMessageById(@Param("mid") Integer messageId);
}
