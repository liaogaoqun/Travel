package Lgq_travel.springboot.service;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.Scenic;
import Lgq_travel.springboot.utils.Page;

import java.util.List;

public interface ScenicService {
    List<Scenic> selectScenicList();
    Page<Scenic> selectPageByQueryVo(QueryVo vo);
}
