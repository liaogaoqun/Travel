package Lgq_travel.springboot.service.Impl;

import Lgq_travel.springboot.entity.Manager;
import Lgq_travel.springboot.mapper.ManagerMapper;
import Lgq_travel.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public int insertManager(Manager manager) {
        return managerMapper.insertManager(manager);
    }

    @Override
    public int deleteManager(Integer id) {
        return managerMapper.deleteManager(id);
    }

    @Override
    public List<Manager> getAllManager(String name) {
        return managerMapper.getAllManager(name);
    }

    @Override
    public Manager confirmManager(Manager manager) {
        return managerMapper.confirmManager(manager);
    }
}
