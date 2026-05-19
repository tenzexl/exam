# Online Course Platform Backend

## Quick start
1. Build and run all services:
   - `docker compose up --build`
2. pgAdmin UI:
   - http://localhost:5050
   - Login: admin@admin.com / admin
3. App Swagger UI:
   - http://localhost:8080/swagger-ui/index.html

## Local run (without Docker)
- Start PostgreSQL locally
- Update `src/main/resources/application.yml`
- Run the app:
  - `mvn spring-boot:run`

## Postgres connection (pgAdmin)
- Host: `postgres` (if using docker-compose)
- Port: 5432
- DB: course_platform
- User: postgres
- Pass: postgres
- Role: ADMIN, INSTRUCTOR, STUDENT

## Roles
- `ADMIN` - full access, can manage users.
- `INSTRUCTOR` - create courses, lessons, assignments.
- `STUDENT` - enroll and submit assignments.

## API endpoints (main)
- Auth: `POST /api/auth/register`, `POST /api/auth/login`
- Users: `POST /api/users`, `GET /api/users`, `GET /api/users/{id}`, `DELETE /api/users/{id}`
- Courses: `POST /api/courses`, `GET /api/courses/{id}`, `PUT /api/courses/{id}`, `DELETE /api/courses/{id}`
- Course search: `GET /api/courses` with query params `q`, `level`, `active`, `instructorId`, `page`, `size`, `sort`
- Lessons: `POST /api/lessons`, `GET /api/lessons`, `GET /api/lessons/{id}`, `PUT /api/lessons/{id}`, `DELETE /api/lessons/{id}`
- Enrollments: `POST /api/enrollments`, `GET /api/enrollments`, `GET /api/enrollments/{id}`, `DELETE /api/enrollments/{id}`
- Assignments: `POST /api/assignments`, `GET /api/assignments`, `GET /api/assignments/{id}`, `PUT /api/assignments/{id}`, `DELETE /api/assignments/{id}`
- Submissions: `POST /api/submissions`, `GET /api/submissions`, `GET /api/submissions/{id}`, `PUT /api/submissions/{id}`, `DELETE /api/submissions/{id}`
- Files: `POST /api/files/upload`, `GET /api/files/{id}`
## Notes
- JWT secret can be changed via `JWT_SECRET` env var (min 32 chars).
- Uploaded files are stored in `storage/` by default.
