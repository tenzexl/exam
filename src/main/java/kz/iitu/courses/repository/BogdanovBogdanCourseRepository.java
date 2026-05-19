package kz.iitu.courses.repository;

import kz.iitu.courses.model.BogdanovBogdanCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BogdanovBogdanCourseRepository extends JpaRepository<BogdanovBogdanCourse, Long>, JpaSpecificationExecutor<BogdanovBogdanCourse> {
}
