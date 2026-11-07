CREATE EXTENSION IF NOT EXISTS postgis;

CREATE TABLE app_meta (
  key       text PRIMARY KEY,
  value     text NOT NULL,
  updated_at timestamptz NOT NULL DEFAULT now()
);
