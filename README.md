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

## Notes
- JWT secret can be changed via `JWT_SECRET` env var (min 32 chars).
- Uploaded files are stored in `storage/` by default.
