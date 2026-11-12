CREATE TABLE companies (
                           id          UUID         PRIMARY KEY,
                           name        VARCHAR(255) NOT NULL,
                           tax_id      VARCHAR(9)   NOT NULL,
                           status      VARCHAR(20)  NOT NULL DEFAULT 'ACTIVE',
                           created_at  TIMESTAMPTZ  NOT NULL DEFAULT now(),
                           version     BIGINT       NOT NULL DEFAULT 0,

                           CONSTRAINT uk_companies_tax_id UNIQUE (tax_id)
);