Yabi:Backend
------------

This project contains the api implemetation for the yabi project


Notes
-----

1. The build.sh script
   builds the _custom_ docker image for microsoft's sql server. Apparently they did not antecipate a data entrypoint like the other database images, namely mariadb, oracle xe and postgre's image. In an attempt to automate, this image have a little hack in it's **CMD** that "fixes" it, unless the image teakes more than 20 seconds to boot.
