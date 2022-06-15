INSERT INTO users(id, email, first_name, last_name, image_url, is_active, password)
VALUES (1, 'test@test.com', 'Nikolay', 'Kostadinov', null, 1,
        '251eb33fd6155b2da407ec7ec55be425ef83445febc2fb601a7ccd2c6d98ee0d71db19c734814423');

INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota');

INSERT INTO models(id, `name`, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1,  'https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg'),
       (2, 'Mondeo', 'CAR', 1992, null, 1,  'https://upload.wikimedia.org/wikipedia/commons/b/b1/Ford_Mondeo_reg_dec_2010_West_Road_Cambridge_2011_1997cc_diesel.jpg'),
       (3, 'Supra', 'CAR', 1978, 2002, 2,  'https://upload.wikimedia.org/wikipedia/commons/e/e5/2020_Toyota_GR_Supra_%28United_States%29.png'),
       (4, 'Celica', 'CAR', 1971, 2006, 2,  'https://automedia.investor.bg//media/files/resized/article/w1200x630/118/a5ac95bccd55f80f43544402f3592118-04-1.jpg');
