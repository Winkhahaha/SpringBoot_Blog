package edu.mineok.service;


import edu.mineok.entity.Tag;
import edu.mineok.exception.NotFoundException;
import edu.mineok.repository.TagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    public Tag getTag(Long id) {
        return tagRepository.findById(id).get();
    }

    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Transactional
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }


    @Transactional
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(tag, t);
        return tagRepository.save(t);
    }


    @Transactional
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Transactional
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Transactional
    public List<Tag> listTag(String ids) {   // 1,2,3
        return tagRepository.findAllById(convertToList(ids));
    }

    // 1,2,3字符串转列表
    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i = 0; i < idarray.length; i++) {
                list.add(Long.parseLong(idarray[i]));
            }
        }
        return list;
    }

}
