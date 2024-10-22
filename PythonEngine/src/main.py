import Detecter as Detecter
from fastapi import FastAPI
import uvicorn
import time
from ultralytics import YOLO

app = FastAPI()

model = YOLO('../app/yolov8n/yolov8n.pt')

@app.get("/")
def detect(path:str):
    detector = Detecter.Detector(immagine=path,model=model)
    print(detector)
    return detector.detect()
if __name__ == "__main__":
    uvicorn.run(app, port = 8000, host = "0.0.0.0")