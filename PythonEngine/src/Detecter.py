from ultralytics import YOLO
import os
class Detector:

    def __init__(self,immagine,model):
        self.immagine = f'../app{immagine}'
        self.threshold = 0.3
        self.model = model

    def detect(self):
        try:

            auto = 0
            camion = 0
            moto = 0

            results = self.model(self.immagine,conf=self.threshold, classes = [2,3,5,7],save=True, project = "/app/output", exist_ok=True, name="predict")
            for result in results:
                for detection in result:
                    classId = detection.boxes.data[0][5]
                    #se è un'auto
                    if classId== 2.0:
                        auto +=1
                    #se è un camion
                    elif classId == 3.0:
                        moto +=1
                    elif classId == 7.0 or classId == 5.0:
                        camion +=1

            return {"auto":auto,"camion":camion,"moto":moto}
        except Exception as e:
            print(e)

    def getCamera(self,immagines:str): #prende l'id della cam dell'immagine che è stata passata (serve per sapere identificare la cam che ha fatto la foto in questione)
        return immagines.split("cam")[2].split(".jpg")[0]