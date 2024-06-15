package Lgq_travel.springboot.service.Impl;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.Scenic;
import Lgq_travel.springboot.mapper.ScenicMapper;
import Lgq_travel.springboot.service.ScenicService;
import Lgq_travel.springboot.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenicServiceImpl implements ScenicService {
    @Autowired
    private ScenicMapper scenicMapper;
    @Override
    public List<Scenic> selectScenicList() {
        return scenicMapper.selectAllScience();
    }

    @Override
    public Page<Scenic> selectPageByQueryVo(QueryVo vo) {
        Page<Scenic> page = new Page<Scenic>();
        //每页数
        page.setSize(5);
        vo.setSize(5);
        if (null != vo) {
            // 判断当前页
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() - 1) * vo.getSize());
            }
            if(null != vo.getName() && !"".equals(vo.getName().trim())){
                vo.setName(vo.getName().trim());
            }
            if(null != vo.getTheme() && !"".equals(vo.getTheme().trim())){
                vo.setTheme(vo.getTheme().trim());
            }
            if(null != vo.getAddr() && !"".equals(vo.getAddr().trim())){
                vo.setAddr(vo.getAddr().trim());
            }
            //总条数
            page.setTotal(scenicMapper.postCountByQueryVo(vo));
            page.setRows(scenicMapper.selectPostScience(vo));
        }
        return page;
    }
}
