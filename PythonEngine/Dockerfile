FROM python:3.10.5

WORKDIR /api

COPY requirements.txt .

RUN apt-get update && apt-get install ffmpeg libsm6 libxext6 -y
RUN pip install -r requirements.txt

COPY ./src ./src

CMD ["python", "./src/main.py"]