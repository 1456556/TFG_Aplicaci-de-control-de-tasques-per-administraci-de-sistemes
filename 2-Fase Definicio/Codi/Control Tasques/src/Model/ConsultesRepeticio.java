/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Victor
 */
public class ConsultesRepeticio {

    public void RepeticioDia(Tasques tas) {

        int validacio = 0;
        String dataInici, dataFinal, horaInici, horaFinal;
        dataInici = tas.getData();
        dataFinal = tas.getDataFinal();
        horaInici = tas.getHora();
        horaFinal = tas.getHoraFinal();

        if (dataInici.equals("")) {

            validacio++;

        }
        if (dataFinal.equals("")) {

            validacio++;

        }
        if (horaInici.equals("")) {

            validacio++;

        }
        if (horaFinal.equals("")) {

            validacio++;

        }

    }

}
