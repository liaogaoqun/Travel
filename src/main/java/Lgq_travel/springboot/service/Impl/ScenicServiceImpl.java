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
//    public Page<Scenic> selectPageByQueryVo(QueryVo vo) {
//        Page<Scenic> page = new Page<Scenic>();
//        //每页数
//        page.setSize(5);
//        vo.setSize(5);
//        if (null != vo) {
//            // 判断当前页
//            if (null != vo.getPage()) {
//                page.setPage(vo.getPage());
//                vo.setStartRow((vo.getPage() - 1) * vo.getSize());
//            }
//            if(null != vo.getName() && !"".equals(vo.getName().trim())){
//                vo.setName(vo.getName().trim());
//            }
//            if(null != vo.getTheme() && !"".equals(vo.getTheme().trim())){
//                vo.setTheme(vo.getTheme().trim());
//            }
//            if(null != vo.getAddress() && !"".equals(vo.getAddress().trim())){
//                vo.setAddress(vo.getAddress().trim());
//            }
//            //总条数
//            page.setTotal(scenicMapper.postCountByQueryVo(vo));
//            page.setRows(scenicMapper.selectPostScience(vo));
//        }
//        return page;
//    }

    public Page<Scenic> selectPageByQueryVo(QueryVo vo) {
        Page<Scenic> page = new Page<Scenic>();
        //设置数据库返回值每页数量
        vo.setSize(5);
        //设置页面最大数量
        page.setSize(5);
        if (vo != null) {
            //设置当前页面以及开始行
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() - 1) * vo.getSize());
            }
            if (vo.getName() != null && !"".equals(vo.getName().trim())) {
                vo.setName(vo.getName().trim());
            }
            if (vo.getAddress() != null && !"".equals(vo.getAddress().trim())) {
                vo.setAddress(vo.getName().trim());
            }
            if (vo.getTheme() != null && !"".equals(vo.getTheme().trim())) {
                vo.setTheme(vo.getTheme().trim());
            }
            if (vo.getHot() != null && !"".equals(vo.getHot())) {
                vo.setHot(vo.getHot());
            }
            //总条数
            page.setTotal(scenicMapper.postCountByQueryVo(vo));
            //结果集
            page.setRows(scenicMapper.selectPostScience(vo));
        }
        return page;
    }

    @Override
    public Scenic getScenicById(Integer id) {
        return scenicMapper.selectScenicById(id);
    }
}
