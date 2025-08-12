package demo;

import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RepositoryEventHandler
public class BookEventHandler {
    @HandleBeforeCreate
    public void handleCreate(Book b) {
        if (b.getCreatedAt() == null) b.setCreatedAt(Instant.now());
    }
}
