FROM nginx:alpine
COPY ./ngnix.conf /etc/nginx/conf.d/default.conf
COPY dist/frontend/browser /usr/share/nginx/html
EXPOSE 80
