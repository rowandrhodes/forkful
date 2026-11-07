.PHONY: db-up db-down db-reset db-new

MIGRATIONS_DIR := src/main/resources/db/migration

# Start Postgres and wait until its healthcheck passes.
db-up:
	docker compose up -d --wait

# Stop Postgres, keeping its data.
db-down:
	docker compose down

# Delete all local data and start again with an empty database.
db-reset:
	docker compose down --volumes
	docker compose up -d --wait

db-migrate:
	docker compose run --rm flyway migrate

db-info:
	docker compose run --rm flyway info

db-new:       ## usage: make db-new name=create_users
	@test -n "$(name)" || (echo "usage: make db-new name=create_users"; exit 1)
	@last=$$(ls $(MIGRATIONS_DIR) | sed -n 's/^V\([0-9]*\)__.*/\1/p' | sort -n | tail -1); \
	next=$$(( $${last:-0} + 1 )); \
	file=$(MIGRATIONS_DIR)/V$${next}__$(name).sql; \
	touch $$file && echo "Created $$file"

db-clean:     ## LOCAL ONLY: drop everything, then re-run all migrations
	docker compose run --rm -e FLYWAY_CLEAN_DISABLED=false flyway clean
	docker compose run --rm flyway migrate