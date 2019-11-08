DO $$
    DECLARE
        tabnames RECORD;
    BEGIN
        FOR tabnames IN (SELECT tablename FROM pg_tables
                        WHERE schemaname = current_schema()
                        AND tablename like 'rv_%')
    LOOP
        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(tabnames.tablename) || ' CASCADE';
    END LOOP;
END $$;

DROP TYPE IF EXISTS rv_periodicity;
DROP TYPE IF EXISTS rv_event_type;
DROP TYPE IF EXISTS rv_role;
DROP TYPE IF EXISTS rv_priority;
DROP TYPE IF EXISTS rv_chat_type;
