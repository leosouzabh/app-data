docker run -v /home/leosouzabh/dev/wks/sts/frutas/docker/data:/var/lib/mysql \
    -e MYSQL_ROOT_PASSWORD=root \
	-p 3306:3306 \
	-d mysql