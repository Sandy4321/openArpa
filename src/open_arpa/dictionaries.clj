;Copyright 2016 Adriano Peluso <catonano@gmail.com> Converting the Arpa Puglia spreadsheets into a .ttl file.

;This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, with an exception added by the author; either version 3 of the License, or (at your option) any later version.

;A copy of such license (in its version 3.0) with the aforementioned exception can be found at the root of this distribution in the COPYING file

;This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.


(ns open-arpa.dictionaries
 (:require [clojure.java.io :as io]
           [clojure.edn :as edn]))

(def stations  {
                "Liceo Scientifico" "Liceo Scientifico"
                "MANDURIA" "Manduria"
                "MESAGNE 2" "Mesagne 2"
                "Quartiere Bozzano" "Quartiere Bozzano"
                "Scuola Elementare" "Scuola Elementare"
                "Costa Morena Diga" "Costa Morena Diga"
                "Costa Morena EST" "Costa Morena EST"




                "Altamura" "Via Golgota"
                "Andria" "Via Vaccina"
                "Arnesano" "Arnesano Riesci"
                "Baldassarre" "Villa Baldassarre"
                "CUS" "Cus"
                "Caldarola" "Caldarola"
                "Campi Salentina" "ITC Costa Via Napoli"
                "Capitaneria di Porto" "Capitaneria di Porto" 
                "Carbonara" "Carbonara"
                "Casamassima" "Via Lapenna"
                "Ceglie - Messapica" "Ceglie Messapica"
                "Corso Cavour" "Cavour"
                "ENAIP" "Enaip"
                "Enel Torchiarolo" "Via Fanin"
                "Foggia Via Rosati" "Rosati"
                "Francavilla F.na Via F.Filzi" "Via Fabio Filzi"
                "GROTTAGLIE" "Grottaglie"
                "Galatina" "ITC La Porta"
                "Lecce-Piazza Palio" "P.zza Palio"
                "Lendinuso" "Lendinuso" 
                "MARTINA FRANCA" "Martina Franca"
                "Maglie" "ITC De Castro"
                "Massafra (TA) Via Frappietro" "Via Frappietro"
                "Mesagne" "Mesagne" 
                "ASM" "ASM"
                "Molfetta Verdi" "Verdi"
                "Monopoli" "Viale Aldo Moro"
                "Monopoli Italgreen" "Via Pisonio"
                "P.za San Giusto Casale" "Casale"
                "Paolo VI -CISI" "Zona CISI"
                "Piazza Kennedy" "Kennedy"
                "Piazza_Libertini" "P.zza Libertini"
                "Giorgiloro" "Giorgiloro" 
                "S. Barbara" "S. BARBARA"
                "S. Pancrazio S." "San Pancrazio Salentino"
                "S. Pietro  Vernotico" "San Pietro Vernotico"
                "S.I.S.R.I." "SISRI"
                "S.Maria Cerrate" "S.Maria Cerrate" 
                "S.VITO Colonia Marina" "San Vito"
                "SS7 Wind" "SS7 Ponte Wind"
                "STATTE sc.elementare" "Via Delle Sorgenti"
                "San Vito dei Normanni" "San Vito dei Normanni" 
                "Suolo Giuffreda" "suolo Giuffreda" 
                "Surbo-Enel" "Via B. Croce"
                "TA V. Machiavelli" "Via Machiavelli"
                "TA V.Archimede" "Via Archimede"
                "TAR v.Alto Adige" "Via Alto Adige"
                "Talsano" "Via Ugo Foscolo"
                "Terminale Passeggeri" "Terminal Passeggeri" 
                "Torchiarolo" "Torchiarolo"
                "Via Cappuccini" "Via Cappuccini" 
                "Via Casardi - C. Sportivo" "Via Casardi"
                "Via Crati-Rione Perrino" "Rione Perrino"
                "Via Dei Mille" "Via dei Mille"
                "Via Garilliano" "Via Garilliano"
                "Via Taranto" "Via Taranto"
                "valzani_sanpietrovernotico" "ITC Valzani"
                })



(def pollutants  {
                  "BENZENE" "HC"
                  "Benzene" "HC"
                  "CH4" "CH4"
                  "CO" "CO"
                  "D.V." "DV" 
                  "DV" "DV"
                  "DVG" "DVG"
                  "DVP" "DVP"
                  "E-BENZENE" "E-C6H6" 
                  "H2S" "H2S"
                  "IPA TOT" "IPA"
                  "MP-XYLENE" "MP-XYLENE"
                  "NMHC" "NMHC"
                  "NO" "NO"
                  "NO2" "NO2"
                  "NO2api" "NO2api" 
                  "NOX" "NOx"
                  "NOx" "NOx"
                  "NOxapi" "Noxapi"
                  "O-XYLENE" "O-XYLENE"
                  "O3" "O3"
                  "PIOGGIA" ""
                  "PM10" "PM10"
                  "PM10 B" "PM10biora"
                  "PM10 biora" "PM10biora"
                  "PM2.5" "Pm2.5"
                  "PRESS" "Pressione"
                  "PRESS." "Pressione"
                  "PRESSIONE" "Pressione"
                  "Pioggia" "Pioggia" 
                  "RAD.GLOB." "RAD GLOB"
                  "RADGLOB" "RAD GLOB"
                  "RADS" "RADS"
                  "RADSG" "RADSG"
                  "RADSG." "RADSG"
                  "RADSN" "RADSN"
                  "RADST" "RADST"
                  "SIGMA" "SIGMA"
                  "SO2" "SO2"
                  "TEMP" "Temp"
                  "TEMP EST" "Temp"
                  "TEMP." "Temp"
                  "TOLUENE" "TOLUENE"
                  "Toluene" "TOLUENE"
                  "UMID" "Umidità"
                  "UMID." "Umidità"
                  "UMIDITA E" "Umidità"
                  "UMR" "Umidità"
                  "UMR." "Umidità"
                  "V.V." "VV"
                  "VV" "VV"
                  "VVP" "VVP"
                  })

(def measurement-units {
                  "HC" "ug/m3 293K"
                  
                  "CH4" "ug-C/m3"
                  "CO" "mg/m3 293K"
                  "DV" "SETTORE"
                  
                  "DVG" "DVG"
                  "DVP" "SETTORE"
                  "E-C6H6" "ug/m3 293K"
                  "H2S" "ug/m3 293K"
                  "IPA" "ng/m3"
                  "MP-XYLENE" ""
                  "NMHC" "ug-C/m3"
                  "NO" "ug/m3 293K"
                  "NO2" "ug/m3 293K"
                  "NO2api" "ug/m3 293K"
                  "NOx" "ug/m3 293K"
                  
                  "Noxapi" "ug/m3 293K"
                  "O-XYLENE" ""
                  "O3" "ug/m3 293K"
                  "PIOGGIA" "mm"
                  "PM10" "ug/m3"
                  "PM10biora" "ug/m3"
                  
                  "Pm2.5" "ug/m3"
                  "Pressione" "mbar"
                  "Pioggia" "mm"
                  "RAD GLOB" "W/m2"
                  
                  "RADS" "W/m2"
                  "RADSG" "W/m2"
                  
                  "RADSN" "W/m2"
                  "RADST" "W/m2"
                  "SIGMA" "gradi"
                  "SO2" "ug/m3 293K"
                  "Temp" "gradi C."
           
                  "TOLUENE" "ug/m3 293K"
              
                  "Umidità" "%"
                  "VV" "m/s"
                 
                  "VVP" "m/s"

                        })
