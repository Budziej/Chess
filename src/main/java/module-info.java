module chess {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens com.blazejprzyluski.chess.GUI;
    opens com.blazejprzyluski.chess.client;
    opens com.blazejprzyluski.chess.Pieces;
    opens com.blazejprzyluski.chess.Logic;
    opens com.blazejprzyluski.chess.Board;
}