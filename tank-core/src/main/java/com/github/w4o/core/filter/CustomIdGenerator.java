package com.github.w4o.core.filter;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.github.w4o.core.util.IdGenerator;
import org.springframework.stereotype.Component;

/**
 * @author frank
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
        IdGenerator idGenerator = new IdGenerator(0, 0);
        return idGenerator.nextId();
    }
}
