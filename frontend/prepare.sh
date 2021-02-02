npm run build
cd ..
rm -rfv src/main/resources/static/*
cp -a frontend/build/. src/main/resources/static/