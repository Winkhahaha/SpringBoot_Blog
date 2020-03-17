package edu.mineok.service;

import edu.mineok.entity.Type;
import edu.mineok.exception.NotFoundException;
import edu.mineok.repository.TypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    public Optional<Type> getType(Long id) {
        return typeRepository.findById(id);
    }

    @Transactional
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Transactional
    public List<Type> listType(){
        return typeRepository.findAll();
    }

    @Transactional
    public Type updateType(Long id, Type type) {
        Optional<Type> t = typeRepository.findById(id);
        if (t.get() == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type, t.get()); // 将新type复制给t.get()(相当于更新)
        return typeRepository.save(t.get());
    }

    @Transactional
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }
}

