INSERT INTO tasks (title, description, status, created_at, updated_at)
VALUES ('Buy milk',
        'Go to the store and buy milk.',
        'DONE', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO tasks (title, description, status, created_at, updated_at)
VALUES ('Take the dog for a walk',
        'Take the dog for a walk around the block and buy some dog food.',
        'TODO', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO tasks (title, description, status, created_at, updated_at)
VALUES ('Clean up the house',
        'Wash the dishes, vacuum the floor, clean the bathroom, do the laundry, take out the trash and make the bed.',
        'DOING', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO tasks (title, status, created_at, updated_at, description)
VALUES ('Lorem ipsum', 'TODO', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas sem ut augue tempus dapibus. ' ||
        'Nam vestibulum neque nec est faucibus, vel imperdiet tellus vestibulum. Phasellus molestie non nisl ut ' ||
        'bibendum. Cras ut commodo eros. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per ' ||
        'inceptos himenaeos. Vivamus sollicitudin, libero eget auctor aliquet, erat dolor pretium nulla, feugiat ' ||
        'mattis dui tortor at lectus. Curabitur mattis tempus tincidunt. Proin ut est ac dolor ultrices mattis. ' ||
        'Nam at dolor et diam laoreet pretium eu id mauris. Aliquam nunc ligula, ultrices sit amet lacus vitae, ' ||
        'consequat mattis neque. Vivamus ultrices augue in velit porttitor porttitor. Praesent ut nulla id sem ' ||
        'feugiat pretium. Proin in nunc eu diam ultrices luctus. Praesent quis tortor lectus. Sed fermentum, neque ' ||
        'nec porta fermentum, turpis justo rutrum purus, in laoreet nibh ante quis quam.');
