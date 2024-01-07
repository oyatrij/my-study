package com.study.jpashop.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;

public class OderSpec {
    public static Specification<Order> memberNameLike (final String memberName) {
        return new Specification<Order>() {
          public Predicate toPredicate (Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
              if (StringUtils.isEmpty(memberName)) return null;
              Join<Order, Member> m = root.join("member", JoinType.INNER);
              return builder.like(m.<String>get("name"), "%" + memberName + "%");
          }
        };
    }

    public static Specification<Order> orderStatusEq(final OrderStatus orderStatus) {
        return new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (orderStatus == null) return null;
                return criteriaBuilder.equal(root.get("status"), orderStatus);
            }
        };
    }
}
