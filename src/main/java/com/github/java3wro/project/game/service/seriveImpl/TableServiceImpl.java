package com.github.java3wro.project.game.service.seriveImpl;

import com.github.java3wro.project.game.model.Table;
import com.github.java3wro.project.game.repository.TableRepository;
import com.github.java3wro.project.game.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableRepository tableRepository;


    @Override
    public Table createTable(Table table) {
        if(table.getId()== null){
            table = tableRepository.save(table);
        }
        return null;
    }
}
