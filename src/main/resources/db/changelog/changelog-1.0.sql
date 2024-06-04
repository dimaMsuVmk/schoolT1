create table if not exists methods
(
    id bigserial primary key not null,
    class_name  VARCHAR(255) NOT NULL,
    method_name VARCHAR(255) NOT NULL
);

create table InfoTimeMethods
(
    id bigserial primary key not null,
    execution_time BIGINT    NOT NULL,
    date           timestamp NOT NULL,
    method_id      BIGINT    NOT NULL,
    CONSTRAINT fk_method_id FOREIGN KEY (method_id) REFERENCES t_methods (method_id)
);