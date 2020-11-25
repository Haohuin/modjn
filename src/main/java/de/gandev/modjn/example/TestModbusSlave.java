package de.gandev.modjn.example;

import de.gandev.modjn.ModbusClient;
import de.gandev.modjn.entity.exception.ConnectionException;
import de.gandev.modjn.entity.exception.ErrorResponseException;
import de.gandev.modjn.entity.exception.NoResponseException;
import de.gandev.modjn.entity.func.WriteSingleRegister;
import de.gandev.modjn.entity.func.response.ReadHoldingRegistersResponse;
import de.gandev.modjn.entity.func.response.WriteMultipleRegistersResponse;

/**
 * @author wjw
 */
public class TestModbusSlave {
    public static void main(String[] args) {
        ModbusClient modbusClient = ClientForTests.getInstance().getModbusClient();
        //写入单个寄存器
        WriteSingleRegister writeSingleRegister = null;
        try {
             writeSingleRegister = modbusClient.writeSingleRegister(12321, 5);
        } catch (NoResponseException e) {
            e.printStackTrace();
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        System.out.println(writeSingleRegister);
        //写入多个寄存器
        int[] arr ={4,4,4,4,4};
        WriteMultipleRegistersResponse writeMultipleRegisters = null;
        try {
             writeMultipleRegisters = modbusClient.writeMultipleRegisters(2200, 5, arr);
        } catch (NoResponseException e) {
            e.printStackTrace();
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        System.out.println(writeMultipleRegisters);
        //读取所有寄存器
        ReadHoldingRegistersResponse readHolding = null;
        try {
           readHolding = modbusClient.readHoldingRegisters(12321, 5);
        } catch (NoResponseException e) {
            e.printStackTrace();
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        System.out.println(readHolding);
        modbusClient.close();
    }
}
