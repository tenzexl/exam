package kz.iitu.courses.util;

import kz.iitu.courses.model.BogdanovBogdanCourse;
import kz.iitu.courses.model.BogdanovBogdanCourseLevel;
import org.springframework.data.jpa.domain.Specification;

public class BogdanovBogdanCourseSpecifications {
    public static Specification<BogdanovBogdanCourse> withFilters(String query, BogdanovBogdanCourseLevel level, Boolean active, Long instructorId) {
        return (root, cq, cb) -> {
            var predicate = cb.conjunction();
            if (query != null && !query.isBlank()) {
                String like = "%" + query.toLowerCase() + "%";
                predicate.getExpressions().add(cb.or(
                    cb.like(cb.lower(root.get("title")), like),
                    cb.like(cb.lower(root.get("description")), like)
                ));
            }
            if (level != null) {
                predicate.getExpressions().add(cb.equal(root.get("level"), level));
            }
            if (active != null) {
                predicate.getExpressions().add(cb.equal(root.get("active"), active));
            }
            if (instructorId != null) {
                predicate.getExpressions().add(cb.equal(root.get("instructor").get("id"), instructorId));
            }
            return predicate;
        };
    }
}
