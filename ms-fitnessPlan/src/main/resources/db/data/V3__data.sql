INSERT INTO suggestion (id, category, suggestion)
SELECT 1, 'dietaryTips', 'Start your day with a glass of water and fresh fruit.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 1 AND category = 'dietaryTips' AND suggestion = 'Start your day with a glass of water and fresh fruit.'
);

INSERT INTO suggestion (id, category, suggestion)
SELECT 2, 'dietaryTips', 'Incorporate plenty of vegetables and whole grains into your meals.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 2 AND category = 'dietaryTips' AND suggestion = 'Incorporate plenty of vegetables and whole grains into your meals.'
);

INSERT INTO suggestion (id, category, suggestion)
SELECT 3, 'dietaryTips', 'Limit processed foods and sugary drinks.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 3 AND category = 'dietaryTips' AND suggestion = 'Limit processed foods and sugary drinks.'
);

INSERT INTO suggestion (id, category, suggestion)
SELECT 4, 'dietaryTips', 'Consult a nutritionist for healthy weight gain.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 4 AND category = 'dietaryTips' AND suggestion = 'Consult a nutritionist for healthy weight gain.'
);

INSERT INTO suggestion (id, category, suggestion)
SELECT 5, 'dietaryTips', 'Dont skip meals - aim for 3 balanced meals and healthy snacks throughout the day.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 5 AND category = 'dietaryTips' AND suggestion = 'Dont skip meals - aim for 3 balanced meals and healthy snacks throughout the day.'
);

INSERT INTO suggestion (id, category, suggestion)
SELECT 6, 'dietaryTips', 'Cook more meals at home to control ingredients and portion sizes.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 6 AND category = 'dietaryTips' AND suggestion = 'Cook more meals at home to control ingredients and portion sizes.'
);

INSERT INTO suggestion (id, category, suggestion)
SELECT 7, 'dietaryTips', 'Focus on portion control and incorporate more fruits, vegetables, and whole grains.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 7 AND category = 'dietaryTips' AND suggestion = 'Focus on portion control and incorporate more fruits, vegetables, and whole grains.'
);

INSERT INTO suggestion (id, category, suggestion)
SELECT 8, 'exercise', 'Walking is a simple and effective way to get active.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 8 AND category = 'exercise' AND suggestion = 'Walking is a simple and effective way to get active.'
);

INSERT INTO suggestion (id, category, suggestion)
SELECT 9, 'exercise', 'Try bodyweight exerciseDaos like squats, lunges, and push-ups for a full-body workout.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 9 AND category = 'exercise' AND suggestion = 'Try bodyweight exerciseDaos like squats, lunges, and push-ups for a full-body workout.'
);

INSERT INTO suggestion (id, category, suggestion)
SELECT 10, 'exercise', 'Find activities you enjoy, like dancing, swimming, or cycling.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 10 AND category = 'exercise' AND suggestion = 'Find activities you enjoy, like dancing, swimming, or cycling.'
);

INSERT INTO suggestion (id, category, suggestion)
SELECT 11, 'exercise', 'Start slow and gradually increase intensity and duration to avoid injury.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 11 AND category = 'exercise' AND suggestion = 'Start slow and gradually increase intensity and duration to avoid injury.'
);

INSERT INTO suggestion (id, category, suggestion)
SELECT 12, 'exercise', 'Dont forget to stretch before and after exercise to improve flexibility.'
    WHERE NOT EXISTS (
    SELECT 1 FROM suggestion WHERE id = 12 AND category = 'exercise' AND suggestion = 'Dont forget to stretch before and after exercise to improve flexibility.'
);


-- INSERT INTO suggestion (id,category, suggestion)
-- VALUES(1,'dietaryTips', 'Start your day with a glass of water and fresh fruit.');
-- INSERT INTO suggestion (id,category, suggestion) VALUES(2,'dietaryTips', 'Incorporate plenty of vegetables and whole grains into your meals.');
-- INSERT INTO suggestion (id,category, suggestion) VALUES(3,'dietaryTips', 'Limit processed foods and sugary drinks.');
-- INSERT INTO suggestion (id,category, suggestion) VALUES(4,'dietaryTips', 'Consult a nutritionist for healthy weight gain.');
-- INSERT INTO suggestion (id,category, suggestion) VALUES(5,'dietaryTips', 'Dont skip meals - aim for 3 balanced meals and healthy snacks throughout the day.');
-- INSERT INTO suggestion (id,category, suggestion) VALUES(6,'dietaryTips', 'Cook more meals at home to control ingredients and portion sizes.');
-- INSERT INTO suggestion (id,category, suggestion) VALUES(7,'dietaryTips', 'Focus on portion control and incorporate more fruits, vegetables, and whole grains.');
-- INSERT INTO suggestion (id,category, suggestion) VALUES(8,'exercise', 'Walking is a simple and effective way to get active.');
-- INSERT INTO suggestion (id,category, suggestion) VALUES(9,'exercise', 'Try bodyweight exerciseDaos like squats, lunges, and push-ups for a full-body workout.');
-- INSERT INTO suggestion (id,category, suggestion) VALUES(10,'exercise', 'Find activities you enjoy, like dancing, swimming, or cycling.');
-- INSERT INTO suggestion (id,category, suggestion) VALUES(11,'exercise', 'Start slow and gradually increase intensity and duration to avoid injury.');
-- INSERT INTO suggestion (id,category, suggestion) VALUES(12,'exercise', 'Dont forget to stretch before and after exercise to improve flexibility.');